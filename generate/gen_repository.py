from jinja2 import Environment, FileSystemLoader
import camelcaser as cc

from helper.read_config import get_janus_config

env = Environment(loader=FileSystemLoader("../templates/"))
template = env.get_template("repository.template")

config = get_janus_config()
for process in config["buzzProcesses"]:
    packageName = process["packageName"]
    for crud in process["cruds"]:
        entity = cc.make_camel_case(crud["table"])
        content = template.render(
            root_package=config["rootPackage"],
            package=packageName,
            entity=entity
        )
        root_package = config["rootPackage"].replace(".", "/")
        filename = f"../output/src/main/java/{root_package}/{packageName}/model/{entity}Repository.java"
        with open(filename, mode="w", encoding="utf-8") as output:
            output.write(content)
