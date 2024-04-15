#!/bin/sh
echo "Generating Project Folders..."
python project_structure.py
echo "Generating POM File..."
python gen_pom.py
echo "Generating Properties File..."
python gen_properties.py
echo "Generating Application Bootstrap..."
python gen_application.py
echo "Generating Class to Handle Exception in Controllers..."
python gen_controller_exception_handler.py
echo "Generating Exception Item Not Found..."
python gen_item_not_found_exception.py
echo "Generating Class DB Primary Key..."
python gen_key_generator.py
echo "Generating DTO Super Class..."
python gen_master_dto.py
echo "Generating Entity Super Class..."
python gen_master_entity.py
echo "Generating Repository Class..."
python gen_repository.py
echo "Generating Entity Class..."
python gen_entity.py
echo "Generating Service Class..."
python gen_service.py
echo "Generating Controller Class..."
python gen_controller.py
