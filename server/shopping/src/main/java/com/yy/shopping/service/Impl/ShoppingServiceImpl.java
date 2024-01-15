package com.yy.shopping.service.Impl;

import com.yy.shopping.dto.MerchandizeListDto;
import com.yy.shopping.dto.ProductDto;
import com.yy.shopping.dto.UploadInfoDto;
import com.yy.shopping.entity.*;
import com.yy.shopping.exception.AlreadyExistedException;
import com.yy.shopping.mapper.ProductMapper;
import com.yy.shopping.repository.*;
import com.yy.shopping.service.ShoppingService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingServiceImpl implements ShoppingService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductNameRepository productNameRepository;
    @Autowired
    ProductInfoRepository productInfoRepository;
    @Autowired
    SellerRepository sellerRepository;
    @Autowired
    ProductTypeRepository productTypeRepository;
    @Autowired
    TypeRepository typeRepository;
    @Autowired
    ProductInfoTypeRepository productInfoTypeRepository;

//    ProductMapper productMapper;
    @Override
    public void uploadProduct(UploadInfoDto uploadInfoDto) {
        // 1. 利用product name和user id在product name中查找product name id
        String name = uploadInfoDto.getTitle();
        long userId = uploadInfoDto.getUserId();
        String typeName = uploadInfoDto.getType();
        Optional<ProductName> byName = productNameRepository.findByName(name);


        if(byName.isPresent()) {
            ProductName productName = byName.get();
            long productNameId = productName.getId();
            // 2.1 查到了id 继续查询是否有seller关系
            Optional<Seller> seller = sellerRepository.findInfoIdNyNameAndUserId(productNameId, userId);
            if(seller.isPresent()) {

                // 3.1 利用type name查找type id
                Optional<Type> typebyName = typeRepository.findByName(typeName);
                if(typebyName.isPresent()) {
                    long typeId = typebyName.get().getId();
                    // 4.1 查到了type id，查是否绑定type关系
                    // 需要修改为productInfoType
                    Optional<ProductType> byNameIdAndUserIdAndTypeId = productTypeRepository.findByNameIdAndUserIdAndTypeId(productNameId, userId, typeId);
                    if (byNameIdAndUserIdAndTypeId.isPresent()) {
                        //5.1 查到了type关系，抛出异常
                        throw new AlreadyExistedException("尺码");
                    }
                    // 5.2 未查到type关系
                    // 5.2.1 直接添加关系
                    addRelationships(uploadInfoDto, userId, productNameId,typeId);
                }else {
                    // 4.1 未查到type id，直接创建type
                    Type newType = new Type();
                    newType.setName(typeName);
                    Type save = typeRepository.save(newType);
                    System.out.println("成功存储type");
                    // 4.2 查找type id
                    long typeId = save.getId();

                    // 4.3 添加各种关系
                    addRelationships(uploadInfoDto, userId, productNameId,typeId);
                }
            } else {
                searchTypeAndAddRelationships(uploadInfoDto, userId, typeName, productNameId);
            }
        } else {
            // 2.1.1 创建product name
            ProductName productName = new ProductName();
            productName.setName(name);
            ProductName save = productNameRepository.save(productName);
            System.out.println(save.getGmtCreated());
            System.out.println("成功存储product name");
            // 2.1.2 查找product id
            long productNameId = save.getId();
            // 2.2 绑定各种关系
            searchTypeAndAddRelationships(uploadInfoDto, userId, typeName, productNameId);
        }
    }

    int start = 0;
    int rowSize = 5;
    int current = 5;
    int merchandizeListId = 0;

    @Override
    public List<MerchandizeListDto> getProductListBySeller(long userId) {
        List<Long> productNameListBySeller = sellerRepository.findProductNameListBySeller(userId);
        int listSize = productNameListBySeller.size();
//        listSize = 6;


        List<MerchandizeListDto> merchandizeList = new ArrayList<>();

        // 5个name为一组 填充MerchandizeListDto
        for (int i = start; i < listSize; i+= rowSize) {
            MerchandizeListDto merchandizeListDto = new MerchandizeListDto();
            List<ProductDto> childrens = new ArrayList<>();
            for (int j = i; j < current && j < listSize; j++) {
                // 使用 product name 获取其中一个 product info
                long productNameId = productNameListBySeller.get(j);
                // 获取 product name
                Optional<ProductName> productNameById = productNameRepository.findById(productNameId);
                String productName = "";
                if (productNameById.isPresent()) productName = productNameById.get().getName();
                // 获取 product info
                Optional<Long> infoIdByProductNameId = sellerRepository.findInfoIdByProductNameId(productNameId);
                if(infoIdByProductNameId.isPresent()) {
                    Optional<ProductInfo> productInfoById = productInfoRepository.findById(infoIdByProductNameId.get());
                    if(productInfoById.isPresent()) {
                        ProductDto productDto = ProductMapper.productInfoToProductDto(productInfoById.get(), new ProductDto(), productName);
                        childrens.add(productDto);
                    }
                }

                System.out.print(j);
            }
            merchandizeListDto.setId(merchandizeListId);
            merchandizeListDto.setChildrens(childrens);
            merchandizeList.add(merchandizeListDto);
            merchandizeListId++;
//            start += rowSize;
            current += rowSize;
            System.out.println(" ");
        }
        current = 5;
        return merchandizeList;
    }


    /**
     * 利用type name在type表中查找是否有现有的type
     * 1. 有：直接添加关系
     * 2. 无：创建type，并添加关系
     * @param uploadInfoDto
     * @param userId
     * @param typeName
     * @param productNameId
     */
    private void searchTypeAndAddRelationships(UploadInfoDto uploadInfoDto, long userId, String typeName, long productNameId) {
        Optional<Type> byTypeName = typeRepository.findByName(typeName);
        if (byTypeName.isPresent()) {
            Type type = byTypeName.get();
            long typeId = type.getId();
            // 5.1 查到了type，直接添加关系
            // 5.1.2 添加各种关系
            addRelationships(uploadInfoDto, userId, productNameId,typeId);
        } else {
            // 5.2 未查到type
            // 5.2.1创建type
            Type newType = new Type();
            newType.setName(typeName);
            Type save = typeRepository.save(newType);
            System.out.println("成功存储type");
            // 5.2.2 查找type id
            long typeId = save.getId();

            // 5.2.3 添加各种关系
            addRelationships(uploadInfoDto, userId, productNameId,typeId);
        }
    }

    /**
     * 1. 添加product info
     * 2. 绑定seller关系
     * 3. 绑定product info type关系
     * @param uploadInfoDto
     * @param userId
     * @param productNameId
     * @param typeId
     */
    private void addRelationships(UploadInfoDto uploadInfoDto, long userId, long productNameId, long typeId) {
        // 5.2.2 添加product info
        ProductInfo productInfo = new ProductInfo();
        productInfo.setDescription(uploadInfoDto.getDescription());
        productInfo.setPrice(uploadInfoDto.getPrice());
        productInfo.setIsDeleted(0);
        productInfo.setUserId(userId);
        productInfo.setProductNameId(productNameId);
        productInfo.setTypeId(typeId);
        ProductInfo save = productInfoRepository.save(productInfo);
        System.out.println("成功存储product info");
        //5.2.2.1 利用user id,product name id,type id查找product info id
        Optional<ProductInfo> byUserIdAndProductNameIdAndTypeId = productInfoRepository.findByUserIdAndProductNameIdAndTypeId(userId, productNameId, typeId);
        long productInfoId = save.getId();
        // 5.2.3 添加seller关系
        Seller sellerRelationship = new Seller();
        sellerRelationship.setProductNameId(productNameId);
        sellerRelationship.setProductInfoId(productInfoId);
        sellerRelationship.setUserId(userId);
        sellerRepository.save(sellerRelationship);
        System.out.println("成功添加seller关系");

        // 5.2.4 添加product info type关系
        ProductInfoType productInfoTypeRelationship = new ProductInfoType();
        productInfoTypeRelationship.setProductInfoId(productInfoId);
        productInfoTypeRelationship.setProductNameId(productNameId);
        productInfoTypeRelationship.setTypeId(typeId);
        productInfoTypeRelationship.setUserId(userId);
        productInfoTypeRepository.save(productInfoTypeRelationship);
        System.out.println("成功添加product info type关系");

        // 5.2.5 添加product type关系
        ProductType productType = new ProductType();
        productType.setProductNameId(productNameId);
        productType.setUserId(userId);
        productType.setTypeId(typeId);
        productTypeRepository.save(productType);
        System.out.println("成功添加product type关系");
    }

    /**
     * 利用typename在type表中查找是否现有。
     * 1. 有：直接添加seller关系和productInfoType关系
     * 2. 无：创建type，并添加关系
     */
    public void typeOperation(Optional<Type> byTypeName) {

    }

    public void saveProduct(UploadInfoDto uploadInfoDto) {

    }
}
