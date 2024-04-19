from jinja2 import Environment, FileSystemLoader

from helper.read_config import get_janus_config


def gen_jwt_decoder():
    env = Environment(loader=FileSystemLoader("../templates/"))
    template = env.get_template("jwt_decoder.template")

    config = get_janus_config()
    content = template.render(root_package=config["rootPackage"])
    root_package = config["rootPackage"].replace(".", "/")
    filename = f"../output/src/main/java/{root_package}/security/config/JwtDecoder.java"
    with open(filename, mode="w", encoding="utf-8") as output:
        output.write(content)
