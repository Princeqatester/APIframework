/*package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders 
{
@DataProvider(name = "Data")
public String[][] getalldata() throws IOException
{
	String path="/Users/princemaini/eclipse-workspace/Pavansir/testdata/file_example_XLSX_50.xlsx";
	XlUtility xl=new XlUtility(path);
	int rownum=xl.getRowCount("Sheet1");
	int colcount=xl.getCellCount("Sheet1",1);
	String apidata[][]=new String[rownum][colcount];
	for(int i=1;i<=rownum;i++)
	{
		for(int j=0;j<colcount;j++)
		{
			apidata[i-1][j]=xl.getCellData("Sheet1", i, j);
		}
	}
	return apidata;
}
}*/
/*package api.utilities;

import java.io.IOException;
import java.util.Arrays;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "Data")
    public Object[][] getAllData() throws IOException {
        String path = "/Users/princemaini/eclipse-workspace/Pavansir/testdata/file_example_XLSX_50.xlsx";
        XlUtility xl = new XlUtility(path);

        // Adjusting the row index to 0 to account for zero-based indexing
        int rownum = xl.getRowCount("Sheet1") - 1; // Subtract 1 to ignore header if needed
        int colcount = 1;           //xl.getCellCount("Sheet1", 1)

        // Initialize the array with the correct dimensions
        String[][] apiData = new String[rownum][colcount];

        // Iterate through rows and columns to populate the array
        for (int i = 1; i <= rownum; i++) { // Start from 1 to skip the header row
            for (int j = 0; j < colcount; j++) {
                apiData[i - 1][j] = xl.getCellData("Sheet1", i, j);
            }
        }
        System.out.println("Data being provided:");
        for (String[] row : apiData) {
            System.out.println(Arrays.toString(row));
        }

        return apiData;
    }
}*/
package api.utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "Data")
    public Object[][] getAllData() throws IOException {
        String path = "/Users/princemaini/eclipse-workspace/Pavansir/testdata/file_example_XLSX_50.xlsx";
        XlUtility xl = new XlUtility(path);

        // Read data from Excel
        int rownum = xl.getRowCount("Sheet1");
        int colcount = 1; // Only one column needed (name)

        // List to hold non-empty rows
        List<String[]> dataList = new ArrayList<>();

        for (int i = 1; i < rownum; i++) { // Start from 1 to skip header
            String cellData = xl.getCellData("Sheet1", i, 0); // Read only the first column

            if (cellData != null && !cellData.trim().isEmpty()) {
                dataList.add(new String[]{cellData});
            }
        }

        // Convert list to array
        String[][] apiData = new String[dataList.size()][colcount];
        for (int i = 0; i < dataList.size(); i++) {
            apiData[i] = dataList.get(i);
        }

        // Print out the data being provided for debugging purposes
        System.out.println("Data being provided:");
        for (String[] row : apiData) {
            System.out.println(Arrays.toString(row));
        }

        return apiData;
    }
}

