from openai import OpenAI


def gen_ai(prompt):
    client = OpenAI(
        organization="<ORG>",
        api_key="<API-KEY>"
    )
    file_prompt = open('../ai/files.prompt', 'r')
    files = file_prompt.readlines()
    prompts = []
    for x in files:
        line = x.rstrip('\n')
        if line != "":
            file_content = open(line, 'r')
            prompts.append({
                "role": "user",
                "content": file_content.read()
            })
    prompts.append({
        "role": "user",
        "content": prompt
    })
    response = client.chat.completions.create(
        model="gpt-4o-mini",
        messages=prompts
    )
    return response.choices[0].message.content.split("```java")[1].split("```")[0]

