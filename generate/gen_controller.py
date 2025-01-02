import camelcaser as cc
from jinja2 import Environment, FileSystemLoader

from helper.read_config import get_janus_config


def gen_controller():
    env = Environment(loader=FileSystemLoader("../templates/"))
    template = env.get_template("controller.template")

    config = get_janus_config()
    for process in config["buzzDomain"]:
        packageName = process["packageName"]
        arr_entity = []
        for crud in process["cruds"]:
            crud["entity"] = cc.make_camel_case(crud["table"])
            crud["entity_var"] = cc.make_lower_camel_case(crud["table"])
            arr_entity.append(crud)
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
        with open("../ai/files.prompt", mode="a", encoding="utf-8") as output:
            output.write("\n" + filename)
