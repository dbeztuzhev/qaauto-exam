# Structure of current project
####Pages package
1. GoogleBasePage - basic page object contains general elements and methods of all pages
2. GoogleLandingPage - page object of main Google page contains elements and methods needed to start search
3. GoogleSearchResultsPage - page object of Google search results page contains elements and methods needed to find search results and format them into a text list and open next search results page

####Tests package
1. GoogleBaseTest - basic test object contains general elements and methods of all tests (before test and after test)
2. GoogleSearchTest - test for validating of Google search results, checks 1 and 2 pages search results to contain search term. Possible to be expanded for more pages.

####General files:
1. .gitignore - to initialize files and folders to be ignored by VCS
2. pom.xml - to set general information about project, dependencies to external libraries
3. search-tests.xml - to launch test suite for Google search test (parametrized browsers)

# User guide to launch tests

####**Downloading:**
1. File explorer → This PC → right click → Properties: look if you have 32 or 64 bit OS
2. Google → “jdk” → Oracle site → “download” --> if 32bit Windows → jdk 7 → if 64bit → jdk 10 *(last one)* → Accept license agreement → choose OS → "download"
3. Google --> "Mozilla Firefox download" --> first site --> "download" or upload to a new version
4. Google --> "Google Chrome download" --> first site --> "download" or upload to a new version

####**Installation:**
Run installers 2, 3, 4 from downloading → click “Next”


####Launch all tests via command line:
1. Open command line 
2. Insert a line "mvn -f C:\local\path\to\pom.xml clean install"

