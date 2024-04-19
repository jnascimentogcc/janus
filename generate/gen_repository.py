import camelcaser as cc
from jinja2 import Environment, FileSystemLoader

from helper.read_config import get_janus_config


def gen_repository():
    env = Environment(loader=FileSystemLoader("../templates/"))
    template = env.get_template("repository.template")

    config = get_janus_config()
    for process in config["buzzProcesses"]:
        packageName = process["packageName"]
        for crud in process["cruds"]:
            arr_unique = []
            for column in crud["columns"]:
                if column["unique"]:
                    arr_unique.append({
                        "column": cc.make_camel_case(column["name"]),
                        "column_var": cc.make_lower_camel_case(column["name"]),
                        "type": column["type"]
                    })
            arr_list_contain = []
            for op in crud["ops"]:
                if op["verb"] == "GET" and op["type"] == "LIST" and op["condition"] == "CONTAIN":
                    arr_list_contain.append({
                        "column": cc.make_camel_case(op["findBy"]),
                        "column_var": cc.make_lower_camel_case(op["findBy"]),
                        "field": cc.make_camel_case(op["field"])
                    })
            arr_list_exactly = []
            for op in crud["ops"]:
                if op["verb"] == "GET" and op["type"] == "LIST" and op["condition"] == "EXACTLY":
                    arr_list_exactly.append({
                        "column": cc.make_camel_case(op["findBy"]),
                        "column_var": cc.make_lower_camel_case(op["findBy"]),
                        "field": cc.make_camel_case(op["field"])
                    })
            entity = cc.make_camel_case(crud["table"])
            content = template.render(
                root_package=config["rootPackage"],
                package=packageName,
                entity=entity,
                unique=arr_unique,
                contain=arr_list_contain,
                exactly=arr_list_exactly,
                has_list=len(arr_list_contain) > 0 or len(arr_list_exactly) > 0,
                has_unique=len(arr_unique) > 0
            )
            root_package = config["rootPackage"].replace(".", "/")
            filename = f"../output/src/main/java/{root_package}/{packageName}/model/{entity}Repository.java"
            with open(filename, mode="w", encoding="utf-8") as output:
                output.write(content)
