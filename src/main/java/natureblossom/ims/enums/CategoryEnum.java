package natureblossom.ims.enums;

/**
 * Enum of product categories.
 *
 * @author R.Yazaki
 * @version 1.0.0
 */
public enum CategoryEnum {
	/**
	 * Define categories.
	 */
	electronics("electronics"),
	furniture("furniture"),
	food("food"),
	clothes("clothes"),
	books("books"),
	others("others");

	/** product category */
	private String category;

	/**
	 * Generate categories.
	 *
	 * @param category
	 */
	private CategoryEnum(String category) {
		this.category = category;
	}

	/**
	 * Get category.
	 *
	 * @return category
	 */
	public String getCategory() {
		return this.category;
	}
}