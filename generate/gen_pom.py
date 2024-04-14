from jinja2 import Environment, FileSystemLoader

from helper.read_config import get_janus_config

env = Environment(loader=FileSystemLoader("../templates/"))
template = env.get_template("pom_xml.template")

config = get_janus_config()
content = template.render(
    root_package=config["rootPackage"],
    app_name=config["appName"],
    app_id=config["appId"]
)
root_package = config["rootPackage"].replace(".", "/")
filename = "../output/pom.xml"
with open(filename, mode="w", encoding="utf-8") as output:
    output.write(content)
