import camelcaser as cc
from jinja2 import Environment, FileSystemLoader

from helper.read_config import get_janus_config


def gen_entity():
    env = Environment(loader=FileSystemLoader("../templates/"))
    template = env.get_template("entity.template")

    config = get_janus_config()
    for process in config["buzzProcesses"]:
        packageName = process["packageName"]
        for crud in process["cruds"]:
            entity = cc.make_camel_case(crud["table"])
            entity_var = cc.make_lower_camel_case(crud["table"])
            arr_columns = []
            for column in crud["columns"]:
                column["table_name"] = column["name"]
                column["name"] = cc.make_lower_camel_case(column["name"])
                arr_columns.append(column)
            arr_one_to_many = []
            for one_to_many in crud["oneToMany"]:
                arr_one_to_many.append(cc.make_camel_case(one_to_many["referencedTable"]))
            arr_many_to_one = []
            for many_to_one in crud["manyToOne"]:
                arr_many_to_one.append({
                    "table_name": many_to_one["referencedTable"],
                    "referenced_table": cc.make_camel_case(many_to_one["referencedTable"]),
                    "referenced_table_var": cc.make_lower_camel_case(many_to_one["referencedTable"])
                })
            content = template.render(
                root_package=config["rootPackage"],
                package=packageName,
                schema=config["databaseSchema"],
                entity=entity,
                entity_var=entity_var,
                table=crud["table"],
                columns=arr_columns,
                one_to_many=arr_one_to_many,
                many_to_one=arr_many_to_one,
                has_list=len(arr_one_to_many) > 0
            )
            root_package = config["rootPackage"].replace(".", "/")
            filename = f"../output/src/main/java/{root_package}/{packageName}/model/{entity}Entity.java"
            with open(filename, mode="w", encoding="utf-8") as output:
                output.write(content)
            with open("../ai/files.prompt", mode="a", encoding="utf-8") as output:
                output.write("\n" + filename)
