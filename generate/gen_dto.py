from jinja2 import Environment, FileSystemLoader
import camelcaser as cc

from helper.read_config import get_janus_config

env = Environment(loader=FileSystemLoader("../templates/"))
template = env.get_template("dto.template")

config = get_janus_config()
for process in config["buzzProcesses"]:
    packageName = process["packageName"]
    for crud in process["cruds"]:
        entity = cc.make_camel_case(crud["table"])
        arr_columns = []
        for column in crud["columns"]:
            column["name"] = cc.make_lower_camel_case(column["name"])
            arr_columns.append(column)
        content = template.render(
            root_package=config["rootPackage"],
            package=packageName,
            entity=entity,
            columns=arr_columns
        )
        root_package = config["rootPackage"].replace(".", "/")
        filename = f"../output/src/main/java/{root_package}/{packageName}/dto/{entity}DTO.java"
        with open(filename, mode="w", encoding="utf-8") as output:
            output.write(content)
