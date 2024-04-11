import os

from helper.read_config import get_janus_config

config = get_janus_config()
root_package = config["rootPackage"].split(".")
folders_array = [
    "../output/src",
    "../output/src/main",
    "../output/src/main/java",
    f"../output/src/main/java/{root_package[0]}",
    f"../output/src/main/java/{root_package[0]}/{root_package[1]}",
    f"../output/src/main/java/{root_package[0]}/{root_package[1]}/helper",
    f"../output/src/main/java/{root_package[0]}/{root_package[1]}/helper/db",
    f"../output/src/main/java/{root_package[0]}/{root_package[1]}/helper/dto",
    f"../output/src/main/java/{root_package[0]}/{root_package[1]}/helper/controller",
    f"../output/src/main/java/{root_package[0]}/{root_package[1]}/helper/exception",
    "../output/src/main/resources"
]
for folder in folders_array:
    if not os.path.exists(folder):
        os.mkdir(folder)
