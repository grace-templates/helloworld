println "Creating a HelloController"

ant.sequential {

    file(name: "app/controllers/${properties['grace.codegen.defaultPackage.path']}/HelloController.groovy",
'''package @grace.codegen.defaultPackage@

class HelloController {
    def index() {
        render 'Hello World!'
    }
}
''')

    replace(file: "app/controllers/${properties['grace.codegen.defaultPackage.path']}/UrlMappings.groovy") {
        replacetoken 'view:"/index"'
        replacevalue 'controller: "hello", action: "index"'
    }

    say 'Done.'
}
