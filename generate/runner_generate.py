from generate.export_project import gen_export_project
"""
from generate.gen_ai_controller import gen_ai_controller
from generate.gen_ai_service import gen_ai_service
from generate.gen_application import gen_application
from generate.gen_auth_controller import gen_auth_controller
from generate.gen_auth_service import gen_auth_service
from generate.gen_controller import gen_controller
from generate.gen_controller_exception_handler import gen_controller_exception_handler
from generate.gen_custom_user_detail_service import gen_custom_user_detail_service
from generate.gen_dto import gen_dto
from generate.gen_endpoint_properties import gen_endpoint_properties
from generate.gen_entity import gen_entity
from generate.gen_item_not_found_exception import gen_item_not_found_exception
from generate.gen_jwt_authentication_filter import gen_jwt_authentication_filter
from generate.gen_jwt_decoder import gen_jwt_decoder
from generate.gen_jwt_issuer import gen_jwt_issuer
from generate.gen_jwt_properties import gen_jwt_properties
from generate.gen_jwt_to_principal_converter import gen_jwt_to_principal_converter
from generate.gen_key_generator import gen_key_generator
from generate.gen_login_request import gen_login_request
from generate.gen_login_response import gen_login_response
from generate.gen_master_dto import gen_master_dto
from generate.gen_master_entity import gen_master_entity
from generate.gen_pom import gen_pom
from generate.gen_project_structure import gen_project_structure
from generate.gen_properties import gen_properties
from generate.gen_repository import gen_repository
from generate.gen_security_roles import gen_security_roles
from generate.gen_service import gen_service
from generate.gen_user_entity import gen_user_entity
from generate.gen_user_principal import gen_user_principal
from generate.gen_user_principal_authentication_token import gen_user_principal_authentication_token
from generate.gen_user_service import gen_user_service
from generate.gen_web_security_config import gen_web_security_config

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
print("Generating AI Service Classes...")
gen_ai_service()
print("Generating AI Controller Classes...")
gen_ai_controller()
print("Generating Security Auth Service...")
gen_auth_service()
print("Generating Security User Service...")
gen_user_service()
print("Generating Security User Entity...")
gen_user_entity()
print("Generating Controller Login Request...")
gen_login_request()
print("Generating Controller Login Response...")
gen_login_response()
print("Generating Controller Auth...")
gen_auth_controller()
print("Generating Config Custom User Detail Service...")
gen_custom_user_detail_service()
print("Generating Config Endpoint Properties...")
gen_endpoint_properties()
print("Generating Config JWT Authentication Filter...")
gen_jwt_authentication_filter()
print("Generating Config JWT Decoder...")
gen_jwt_decoder()
print("Generating Config JWT Issuer...")
gen_jwt_issuer()
print("Generating Config JWT Properties...")
gen_jwt_properties()
print("Generating Config JWT to Principal Converter...")
gen_jwt_to_principal_converter()
print("Generating Config User Principal...")
gen_user_principal()
print("Generating Config User Principal Authentication Token...")
gen_user_principal_authentication_token()
print("Generating Config Web Security...")
gen_web_security_config()
print("Generating Config Security Roles...")
gen_security_roles()
"""
print("Exporting Project...")
gen_export_project()
