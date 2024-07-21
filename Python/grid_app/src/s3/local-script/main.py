"""
Build a grid from the files in a source folder
"""
import glob
import math
from PIL import Image

tile_size = 100
# using the glob module in Python to search for all .jpg in the directory
source_images = glob.glob('resources/source/*.jpg')
image_count = len(source_images)

# calculate the height and width of the grid
tiles_width = math.floor(math.sqrt(image_count))
tiles_height = math.ceil(image_count / tiles_width)

print(f"Converting {image_count} source images. Creating: {tiles_width} x {tiles_height} grid.")

# create new image with given size
destination_image = Image.new(mode="RGB", size=(tiles_width * tile_size, tiles_height * tile_size))

# loop for each tile and draw source image into grid image
for y in range(tiles_height):
    for x in range(tiles_width):
        if source_images:
            filename = source_images.pop()
            with open(filename, "rb") as fd:
                img = Image.open(fd)
                img_width = img.size[0]
                img_height = img.size[1]
                
                # crop the image to a square the length of the shortest side
                crop_square = min(img.size)
                img = img.crop((
                    (img_width - crop_square) // 2,
                    (img_height - crop_square) // 2,
                    (img_width + crop_square) // 2,
                    (img_height + crop_square) // 2
                ))
                
                img = img.resize((tile_size, tile_size))
                
                # draw the image onto the destination grid
                destination_image.paste(img, (x * tile_size, y * tile_size))

# save the resulting grid image
destination_image.save("resources/destination/grid_image.jpg")