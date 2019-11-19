package de.unistuttgart.iaas.cc.exfour;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.*;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class IndexController {


	private final static Logger logger = LoggerFactory.getLogger(IndexController.class);
	private static final String awsCredentialsFile = "aws.properties";

	@RequestMapping("/")
	public String hello(Model model) {

		// TODO: Task 4 - Request database for content of cart
		
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder
			.standard()
			.withEndpointConfiguration(new EndpointConfiguration("http://localhost:8000", "us-east-1"))
			//.withRegion(Regions.US_EAST_1)
			.build();

		ScanRequest scanRequest = new ScanRequest().withTableName("shopping-cart");
		ScanResult result = client.scan(scanRequest);

		model.addAttribute("cart", result);
		return "index";
	}
}
