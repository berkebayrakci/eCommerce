package com.etiya.ecommerceDemo.business.concretes;

import com.etiya.ecommerceDemo.business.abstracts.SupplierService;
import com.etiya.ecommerceDemo.business.dtos.requests.supplier.AddSupplierRequest;
import com.etiya.ecommerceDemo.business.dtos.requests.supplier.UpdateSupplierRequest;
import com.etiya.ecommerceDemo.business.dtos.responses.supplier.AddSupplierResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.supplier.ListSupplierResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.supplier.SupplierDetailResponse;
import com.etiya.ecommerceDemo.business.dtos.responses.supplier.UpdateSupplierResponse;
import com.etiya.ecommerceDemo.core.utils.mapper.ModelMapperService;
import com.etiya.ecommerceDemo.core.utils.result.DataResult;
import com.etiya.ecommerceDemo.core.utils.result.ErrorDataResult;
import com.etiya.ecommerceDemo.core.utils.result.SuccessDataResult;
import com.etiya.ecommerceDemo.entities.concretes.Supplier;
import com.etiya.ecommerceDemo.repositories.abstracts.SupplierDao;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SupplierManager implements SupplierService {

    private SupplierDao supplierDao;
    private ModelMapperService modelMapperService;
    private MessageSource messageSource;

    @Override
    public DataResult<List<ListSupplierResponse>> getAll() {
        return new SuccessDataResult<>(supplierDao.getAll(), messageSource.getMessage("successListSupplier", null, LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<SupplierDetailResponse> getById(Long id) {
        if (supplierDao.getOneSupplierById(id) == null) {
            return new ErrorDataResult<>(supplierDao.getOneSupplierById(id), messageSource.getMessage("errorOneSupplier", null, LocaleContextHolder.getLocale()));
        }
        return new SuccessDataResult<>(supplierDao.getOneSupplierById(id), messageSource.getMessage("successOneSupplier", null, LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<AddSupplierResponse> addSupplier(AddSupplierRequest addSupplierRequest) throws Exception {
        if (supplierDao.existsSupplierBySupplierName(addSupplierRequest.getSupplierName())) {
            throw new Exception(messageSource.getMessage("existsSupplierName", null, LocaleContextHolder.getLocale()));
        }

        Supplier supplier = this.modelMapperService.getMapper().map(addSupplierRequest, Supplier.class);
        supplierDao.save(supplier);

        AddSupplierResponse addSupplierResponse = this.modelMapperService.getMapper().map(supplier, AddSupplierResponse.class);

        return new SuccessDataResult<>(addSupplierResponse, messageSource.getMessage("successAddSupplier", null, LocaleContextHolder.getLocale()));
    }

    @Override
    public DataResult<UpdateSupplierResponse> updateSupplier(UpdateSupplierRequest updateSupplierRequest, Long id) throws Exception {

        if (!supplierDao.existsById(id)) {
            throw new Exception(messageSource.getMessage("errorOneSupplier", null, LocaleContextHolder.getLocale()));
        }

        Supplier supplier = this.modelMapperService.getMapper().map(updateSupplierRequest, Supplier.class);
        supplier.setId(id);
        supplierDao.save(supplier);

        UpdateSupplierResponse updateSupplierResponse = this.modelMapperService.getMapper().map(supplier, UpdateSupplierResponse.class);


        return new SuccessDataResult<>(updateSupplierResponse, messageSource.getMessage("successUpdateSupplier", null, LocaleContextHolder.getLocale()));
    }
}
