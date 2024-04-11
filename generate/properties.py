from jinja2 import Environment, FileSystemLoader

from helper.read_config import get_janus_config

env = Environment(loader=FileSystemLoader("../templates/"))
template = env.get_template("application_properties.template")

config = get_janus_config()
content = template.render(
    root_package=config["rootPackage"],
    server_port=config["serverPort"],
    app_name=config["appName"],
    database_url=config["databaseUrl"],
    database_user=config["databaseUser"],
    database_password=config["databasePassword"],
    database_dialect=config["databaseDialect"]
)
root_package = config["rootPackage"].replace(".", "/")
filename = "../output/src/main/resources/application.properties"
with open(filename, mode="w", encoding="utf-8") as output:
    output.write(content)
