
public class Employees {
	
	private String name;
	private String age;
	private String favoriteFood;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getFavoriteFood() {
		return favoriteFood;
	}

	public void setFavoriteFood(String favoriteFood) {
		this.favoriteFood = favoriteFood;
	}

	public Employees(String name, String age, String favoriteFood) {
		super();
		this.name = name;
		this.age = age;
		this.favoriteFood = favoriteFood;
	}
	@Override
	public String toString() {
		return name + "." + age + "." + favoriteFood;
	}
}
