import boto3
import os
import sys
import io
import pytest
from moto import mock_s3
from PIL import Image

# Add the src directory to the Python path
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '../src')))

@pytest.fixture(scope='module')
def s3_bucket():
    with mock_s3():
        # Create a mock S3 service
        s3 = boto3.client('s3', region_name='us-east-1')
        s3.create_bucket(Bucket='brunosantos-image-input-bucket')
        s3.create_bucket(Bucket='brunosantos-image-destination')

        # Upload existing images to the mock S3 bucket
        for filename in os.listdir('resources/source'):
            if filename.endswith(".jpg"):
                with open(os.path.join('resources/source', filename), 'rb') as img_file:
                    s3.put_object(Bucket='brunosantos-image-input-bucket', Key=filename, Body=img_file)

        yield

def test_s3_script(s3_bucket):
    # Mock sys.argv for the script
    sys.argv = ['main.py', 'brunosantos-image-input-bucket', 'brunosantos-image-destination']

    import s3.s3_script.main

    # Check if the grid image is created in the mock S3 bucket
    s3 = boto3.client('s3', region_name='us-east-1')
    objects = s3.list_objects(Bucket='brunosantos-image-destination')
    assert 'Contents' in objects

    # Download the created grid image and validate its content
    key = objects['Contents'][0]['Key']
    grid_image = s3.get_object(Bucket='brunosantos-image-destination', Key=key)
    img = Image.open(grid_image['Body'])
    assert img.size == (300, 400)
