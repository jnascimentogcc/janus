import os

from helper.read_config import get_janus_config


def gen_project_structure():
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
        f"../output/src/main/java/{root_package[0]}/{root_package[1]}/security",
        f"../output/src/main/java/{root_package[0]}/{root_package[1]}/security/config",
        f"../output/src/main/java/{root_package[0]}/{root_package[1]}/security/controller",
        f"../output/src/main/java/{root_package[0]}/{root_package[1]}/security/model",
        f"../output/src/main/java/{root_package[0]}/{root_package[1]}/security/service",
        "../output/src/main/resources"
    ]
    for process in config["buzzProcesses"]:
        folders_array.append(f"../output/src/main/java/{root_package[0]}/{root_package[1]}/{process["packageName"]}")
        folders_array.append(f"../output/src/main/java/{root_package[0]}/{root_package[1]}/{process["packageName"]}/model")
        folders_array.append(f"../output/src/main/java/{root_package[0]}/{root_package[1]}/{process["packageName"]}/dto")
        folders_array.append(f"../output/src/main/java/{root_package[0]}/{root_package[1]}/{process["packageName"]}/controller")
        folders_array.append(f"../output/src/main/java/{root_package[0]}/{root_package[1]}/{process["packageName"]}/service")
    for folder in folders_array:
        if not os.path.exists(folder):
            os.mkdir(folder)
