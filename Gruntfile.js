
module.exports = function(grunt) {
    grunt.initConfig({
       pkg: grunt.file.readJSON('package.json'),
       wiredep: {
           task: {
               src: [
                   'src/main/webapp/index.jsp'
               ],
           }
       }
    });

    grunt.loadNpmTasks('grunt-wiredep');
    grunt.registerTask('default', ['wiredep']);
}