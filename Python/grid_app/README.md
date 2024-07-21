         ___        ______     ____ _                 _  ___  
        / \ \      / / ___|   / ___| | ___  _   _  __| |/ _ \ 
       / _ \ \ /\ / /\___ \  | |   | |/ _ \| | | |/ _` | (_) |
      / ___ \ V  V /  ___) | | |___| | (_) | |_| | (_| |\__, |
     /_/   \_\_/\_/  |____/   \____|_|\___/ \__,_|\__,_|  /_/ 
 ----------------------------------------------------------------- 
# Image Processing Scripts

## Description

This project contains two scripts for image processing tasks. One script processes images from a local directory, and the other processes images from Amazon S3 buckets. Both scripts create a grid of images and save the resulting grid image.

## Prerequisites

- Python 3.x
- Amazon Cloud9 environment
- AWS credentials configured in your Cloud9 environment with the necessary permissions to access the S3 buckets

## Configure Amazon Cloud9 environment:

- Disable AWS managed temporary credentials in your Cloud9 environment. 
- Make sure your EC2 instance has an IAM role attached with the necessary permissions to access the S3 buckets.

## Install the dependencies:

   ```bash
   pip install -r requirements.txt

## Scripts

### Script 1: Building a Grid of Images from Local Files

This script reads images from a local directory, processes them to create a grid image, and then saves the resulting grid image to a local file.

### Script 2: Building a Grid of Images from S3 Buckets

This script reads images from the `your-image-input-bucket` S3 bucket, processes them to create a grid image, and then saves the resulting grid image to the `your-image-destination` S3 bucket. It also generates a presigned URL for the uploaded grid image.

#### Running the Scripts

###Running Script 1

    Make sure you are in the project root folder.
    Run the script using the following command:
	
	```bash
    python3 src/s3/local_script/main.py

    Check for the .jpg grid image generated in /resources folder.

###Running Script 2

- Ensure you have the required AWS credentials and permissions set up.
- Ensure you have both `your-image-input-bucket` and `your-image-destination` S3 buckets. 
- `your-image-input-bucket` need the .jpg images for the source bucket, you can use/ upload the images located in the resources/source directory with AWS CLI or AWS Management Console.

    Make sure you are in the project root folder.
    Run the script using the following command:
	
    ```bash 
	python3 src/s3/s3_script//main.py [source bucket with the images] [destination bucket]

    Check for the grid image in the generated presigned URL.

###Running the Tests

    Run the tests:
	
	```bash
	pytest tests/

###Notes

- Ensure that your AWS credentials are configured correctly in your Cloud9 environment.
- Disable AWS managed temporary credentials in your Cloud9 environment. 
- Make sure your EC2 instance has an IAM role attached with the necessary permissions to access the S3 buckets.
- Modify the bucket names and directory paths as needed to match your setup.
- Both scripts assume that the images are in the .jpg format.
- Feel free to modify and extend these scripts to suit your specific use case.




