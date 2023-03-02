import groovy.json.JsonSlurper

// Define your choice data as a JSON array
def choiceJson = '''
[
  {"id": "project1", "name": "Project One", "description": "This is the first project"},
  {"id": "project2", "name": "Project Two", "description": "This is the second project"},
  {"id": "project3", "name": "Project Three", "description": "This is the third project"}
]
'''

// Parse the JSON array into a list of maps
def choiceData = new JsonSlurper().parseText(choiceJson)

// Define a Groovy script to generate the descriptions for the choices
def valueNamesScript = """
  def names = []
  ${choiceData.collect { "names.add('${it.name}')" }.join('\n')}
  return names.join('\\n')
"""
