package LearningTestNG;

import org.testng.annotations.Test;

public class DataProvider {

	@Test(dataProvider="SearchProvider")
	public void testMethod(String name,String state) {
		System.out.println("Welcome->"+name+";He is form ->"+state);
	}


	@DataProvider(name="SearchProvider")
	public Object[][] getDataFromDataProvider(){
	return new Object[][]
			{
		{"Pankaj","Maharashtra"},
		{"Mayu","Karnataka"},
		{"sai","Gujarat"}
			};
}
}