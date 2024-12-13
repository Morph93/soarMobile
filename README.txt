Project guide:

Note: 
- Make sure that the application is installed on the device on which you wish to execute your tests.
- I had to switch port from 5000 to 8000 in the app config, I was getting 403 when I started on 5000, so that's the reason, I wrote to 'Ahmed Zakaria Mohamed' on Linkedin but eventually figured out on my own.

main -> java -> driver -> all setup needed to run the project is here(if you're changing a device on which you want to execute tests, open Setup class, and do needed changes).

To execute tests there are two ways :
1. From feature file (src/test/resources/features) -> execute by clicking play button next to the test
2. From runner file (src/test/java/runner) -> execute runner file, it will execute all tests in sequence
