import camelcaser as cc
from jinja2 import Environment, FileSystemLoader

from ai.ai_generate import gen_ai
from helper.read_config import get_janus_config


def gen_ai_service():
    env = Environment(loader=FileSystemLoader("../templates/"))
    template = env.get_template("service.template")

    config = get_janus_config()
    for process in config["buzzProcesses"]:
        package_name = process["packageName"]
        arr_entity = []
        for crud in process["cruds"]:
            arr_many_to_one = []
            for many_to_one in crud["manyToOne"]:
                arr_many_to_one.append({
                    "entity": cc.make_camel_case(many_to_one["referencedTable"]),
                    "entity_var": cc.make_lower_camel_case(many_to_one["referencedTable"])
                })
            crud["entity"] = cc.make_camel_case(crud["table"])
            crud["entity_var"] = cc.make_lower_camel_case(crud["table"])
            crud["many_to_one"] = arr_many_to_one
            arr_entity.append(crud)
        arr_ai = []
        root_package = config["rootPackage"].replace(".", "/")
        filename = f"../output/src/main/java/{root_package}/{package_name}/service/{cc.make_camel_case(package_name)}Service.java"
        for ai in process["ai"]:
            if ai["scope"] == "SERVICE":
                arr_ai.append(gen_ai(ai["prompt"]))
                content = template.render(
                    root_package=config["rootPackage"],
                    package=package_name,
                    entities=arr_entity,
                    service=cc.make_camel_case(package_name),
                    ai=arr_ai
                )
                with open(filename, mode="w", encoding="utf-8") as output:
                    output.write(content)
        with open("../ai/files.prompt", mode="a", encoding="utf-8") as output:
            output.write("\n" + filename)
