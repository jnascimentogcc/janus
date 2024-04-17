from generate.export_project import gen_export_project
from generate.gen_application import gen_application
from generate.gen_controller import gen_controller
from generate.gen_controller_exception_handler import gen_controller_exception_handler
from generate.gen_dto import gen_dto
from generate.gen_entity import gen_entity
from generate.gen_item_not_found_exception import gen_item_not_found_exception
from generate.gen_key_generator import gen_key_generator
from generate.gen_master_dto import gen_master_dto
from generate.gen_master_entity import gen_master_entity
from generate.gen_pom import gen_pom
from generate.gen_project_structure import gen_project_structure
from generate.gen_properties import gen_properties
from generate.gen_repository import gen_repository
from generate.gen_service import gen_service

print("Generating project Structure...")
gen_project_structure()
print("Generating POM.xml...")
gen_pom()
print("Generating Properties File...")
gen_properties()
print("Generating Application Runner...")
gen_application()
print("Generating Controller Exception Handler...")
gen_controller_exception_handler()
print("Generating Item Not Found Exception...")
gen_item_not_found_exception()
print("Generating DB PK Generator...")
gen_key_generator()
print("Generating Superclass Master Entity...")
gen_master_entity()
print("Generating Superclass Master DTO...")
gen_master_dto()
print("Generating Repositories...")
gen_repository()
print("Generating Entities...")
gen_entity()
print("Generating DTO's...")
gen_dto()
print("Generating Service Classes...")
gen_service()
print("Generating Controller Classes...")
gen_controller()
print("Exporting Project...")
gen_export_project()
