package de.unistuttgart.iaas.cc.exfour;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddNewItemToDatabaseCartController {


	private final static Logger logger = LoggerFactory.getLogger(IndexController.class);
	private static final String awsCredentialsFile = "aws.properties";

	@RequestMapping("/set")
	public String hello(@RequestParam(value = "item", required=false, defaultValue = "") String itemToAdd) {


		// TODO: Task4 - Add newItem to the database

		AmazonDynamoDB client = AmazonDynamoDBClientBuilder
			.standard()
			.withEndpointConfiguration(new EndpointConfiguration("http://localhost:8000", "us-east-1"))
			//.withRegion(Regions.US_EAST_1)
			.build();

		Map<String, AttributeValue> newElement = new HashMap<>();

		newElement.put("item", new AttributeValue(itemToAdd));
		client.putItem("shopping-cart", newElement);

		return "set-cookie";
	}
}
