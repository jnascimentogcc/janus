from jinja2 import Environment, FileSystemLoader
import camelcaser as cc

from helper.read_config import get_janus_config

env = Environment(loader=FileSystemLoader("../templates/"))
template = env.get_template("service.template")

config = get_janus_config()
for process in config["buzzProcesses"]:
    packageName = process["packageName"]
    arr_entity = []
    hasList = False
    for crud in process["cruds"]:
        crud["table"] = cc.make_camel_case(crud["table"])
        arr_entity.append(crud)
        for op in crud["ops"]:
            if op["type"] == "LIST":
                hasList = True
    content = template.render(
        root_package=config["rootPackage"],
        package=packageName,
        entities=arr_entity,
        service=cc.make_camel_case(packageName),
        hasList=hasList
    )
    root_package = config["rootPackage"].replace(".", "/")
    filename = f"../output/src/main/java/{root_package}/{packageName}/service/{cc.make_camel_case(packageName)}Service.java"
    with open(filename, mode="w", encoding="utf-8") as output:
        output.write(content)
