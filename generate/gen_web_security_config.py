from jinja2 import Environment, FileSystemLoader

from helper.read_config import get_janus_config


def gen_web_security_config():
    env = Environment(loader=FileSystemLoader("../templates/"))
    template = env.get_template("web_security_config.template")

    config = get_janus_config()

    arr_buzz = []
    for x in config["buzzProcesses"]:
        arr_domain = []
        for y in x["cruds"]:
            arr_op = []
            for z in y["ops"]:
                if z["verb"] == "GET" and z["type"] == "SIMPLE":
                    arr_op.append("GET")
                elif z["verb"] == "GET" and z["type"] == "ALL":
                    arr_op.append("ALL")
                elif z["verb"] == "POST":
                    arr_op.append("POST")
                elif z["verb"] == "PUT":
                    arr_op.append("PUT")
                elif z["verb"] == "DELETE":
                    arr_op.append("DELETE")
            arr_domain.append({
                "domain": y["table"],
                "ops": arr_op
            })
        arr_buzz.append({
            "buzz": x["name"],
            "domains": arr_domain
        })

    content = template.render(
        root_package=config["rootPackage"],
        process=arr_buzz
    )
    root_package = config["rootPackage"].replace(".", "/")
    filename = f"../output/src/main/java/{root_package}/security/config/WebSecurityConfig.java"
    with open(filename, mode="w", encoding="utf-8") as output:
        output.write(content)
