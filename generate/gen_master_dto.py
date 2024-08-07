from jinja2 import Environment, FileSystemLoader

from helper.read_config import get_janus_config


def gen_master_dto():
    env = Environment(loader=FileSystemLoader("../templates/"))
    template = env.get_template("master_dto.template")

    config = get_janus_config()
    content = template.render(root_package=config["rootPackage"])
    root_package = config["rootPackage"].replace(".", "/")
    filename = f"../output/src/main/java/{root_package}/helper/dto/MasterDTO.java"
    with open(filename, mode="w", encoding="utf-8") as output:
        output.write(content)
