package build

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.*
import shared.Loader

abstract class Converter extends DefaultTask {
    @TaskAction
    def convert() {
        def thing = Loader.TARGET;
    }
}
