package com.hunter.utils;

public class ConstantUtil {

	public static enum ProductStatus {
		CONHANG("Còn Hàng"),
		HETHANG("Hết Hàng"),
		SAPMOBAN("Sắp Mở Bán");
		
		private String value;

		private ProductStatus(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
		
	}
	
}
