package prep.day16;

import org.json.JSONArray;
import org.json.JSONObject;

public class UpdateJSON {
	public static void main(String[] args) {
		String jsonPayload = """
				{
				  "orderId": "ORD001",
				  "orderDate": "2025-05-10",
				  "customer": {
				    "name": "Bob Johnson",
				    "address": {
				      "street": "123 Maple Street",
				      "city": "Anytown",
				      "state": "CA",
				      "zip": "90210"
				    },
				    "contact": {
				      "email": "bob@example.com",
				      "phone": "555-4567"
				    }
				  },
				  "items": [
				    {
				      "productId": "P001",
				      "productName": "Laptop",
				      "quantity": 2,
				      "price": 999.99
				    },
				    {
				      "productId": "P003",
				      "productName": "Keyboard",
				      "quantity": 1,
				      "price": 75.5
				    }
				  ],
				  "associatedProblems": [
				    {
				      "problemName": "Diabetes",
				      "medications": [
				        {
				          "medicationName": "Aspirin",
				          "dose": "500 mg"
				        },
				        {
				          "medicationName": "Metformin",
				          "dose": "850 mg"
				        }
				      ]
				    }
				  ],
				  "status": "pending"
				}
				""";
		JSONObject jsonObject = new JSONObject(jsonPayload);
		// System.out.println(jsonObject.toString(2));//2-means 2 white spaces
		JSONArray itemsArray = jsonObject.getJSONArray("items");
		// System.out.println(itemsArray.getJSONObject(0).toString(2));
		// itemsArray.getJSONObject(0).put("productName", "Desktop");
		// System.out.println(itemsArray.getJSONObject(0).toString(2));
		for (int i = 0; i < itemsArray.length(); i++) {
			JSONObject item = itemsArray.getJSONObject(i);
			if (item.getString("productName").equalsIgnoreCase("laptop")) {
				item.put("productName", "Desktop");
			}
		}
		System.out.println(jsonObject.toString(2));
	}
}
