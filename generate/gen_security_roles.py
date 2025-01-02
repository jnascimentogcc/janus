from jinja2 import Environment, FileSystemLoader

from helper.read_config import get_janus_config


def gen_security_roles():
    env = Environment(loader=FileSystemLoader("../templates/"))
    template = env.get_template("security_roles.template")

    config = get_janus_config()

    arr_buzz = []
    for x in config["buzzDomain"]:
        arr_cruds = []
        for y in x["cruds"]:
            arr_ops = ["MANAGER_" + y["table"].upper()]
            for z in y["ops"]:
                if z["verb"] == "GET" and z["type"] == "SIMPLE":
                    arr_ops.append("GET_" + y["table"].upper())
                elif z["verb"] == "GET" and z["type"] == "ALL":
                    arr_ops.append("ALL_" + y["table"].upper())
                elif z["verb"] == "POST":
                    arr_ops.append("ADD_" + y["table"].upper())
                elif z["verb"] == "PUT":
                    arr_ops.append("UPDATE_" + y["table"].upper())
                elif z["verb"] == "DELETE":
                    arr_ops.append("DELETE_" + y["table"].upper())
            arr_cruds.append(", ". join(arr_ops) + ",")
        arr_buzz.append({
            "manager_buzz": "MANAGER_" + x["name"].upper() + ",",
            "roles_domain": arr_cruds
        })
    content = template.render(
        root_package=config["rootPackage"],
        process=arr_buzz
    )
    root_package = config["rootPackage"].replace(".", "/")
    filename = f"../output/src/main/java/{root_package}/security/config/SecurityRoles.java"
    with open(filename, mode="w", encoding="utf-8") as output:
        output.write(content)
