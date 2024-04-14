from jinja2 import Environment, FileSystemLoader
import camelcaser as cc

from helper.read_config import get_janus_config

env = Environment(loader=FileSystemLoader("../templates/"))
template = env.get_template("controller.template")

config = get_janus_config()
for process in config["buzzProcesses"]:
    packageName = process["packageName"]
    arr_entity = []
    for crud in process["cruds"]:
        arr_entity.append(cc.make_camel_case(crud["table"]))
    content = template.render(
        root_package=config["rootPackage"],
        package=packageName,
        entities=arr_entity,
        service=cc.make_camel_case(packageName)
    )
    root_package = config["rootPackage"].replace(".", "/")
    filename = f"../output/src/main/java/{root_package}/{packageName}/controller/{cc.make_camel_case(packageName)}Controller.java"
    with open(filename, mode="w", encoding="utf-8") as output:
        output.write(content)
