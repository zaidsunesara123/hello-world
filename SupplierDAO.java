package com.niit.dao;

import java.util.List;


import com.niit.model.Supplier;

public interface SupplierDAO {

	 public void saveSupplier(Supplier supplier);
	 public void deleteSupplier(Supplier supplier);
	 public void editSupplier(Supplier supplier);
	 public Supplier getSupplier(int supplierID);
     public List<Supplier> getAllSupplier();

}
