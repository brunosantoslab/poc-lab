import sys
import os
import glob
from PIL import Image
import pytest

# Add the src directory to the Python path
sys.path.insert(0, os.path.abspath(os.path.join(os.path.dirname(__file__), '../src')))

# Ensure the source directory exists
os.makedirs('resources/source', exist_ok=True)

def test_local_script():
    import s3.local_script.main

    # Check if the grid image is created
    assert os.path.exists('resources/destination/grid_image.jpg')

    # Validate the image content (simple validation)
    img = Image.open('resources/destination/grid_image.jpg')
    assert img.size == (300, 400)  
