DONOT CHANGE ANY EXISTING CODE IN ANY OF THE FILES
DONOT CHANGE THE NAMES OF ANY OF THE 4 FILES IN THIS FOLDER
YOU JUST HAVE TO SUBMIT MatrixMultiplication.java FILE WITHOUT CHANGING ITS NAME

1. Upload hamcrest-core-1.3.jar, unit-4.12.jar, MatrixMultiplication.java, MatrixMultiplicationTest.java to your AFS through SFTP to remote-linux.eos.ncsu.edu. All these 4 files should be in the same folder

(You can use WinSCP : http://winscp.net/eng/download.php to upload the source code, login with your unity account)

(For Linux users: sftp unity_id@remote-linux.eos.ncsu.edu Then enter your password)

For uploading files: put path_to_your_file

2. use SSH client (such as putty) to connect to remote-linux.eos.ncsu.edu and login with your unity account or you can directly use the command line

(putty: http://www.chiark.greenend.org.uk/~sgtatham/putty/)

(Command line: ssh unity_id@remote-linux.eos.ncsu.edu Then enter you password)

3. Change your working directory to the one which has has these 4 files

4. type: "javac -cp .:junit-4.12.jar MatrixMultiplicationTest.java"

5. type: "java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore MatrixMultiplicationTest"

6. If your code has no errors and it works fine it should print: OK (5 tests)

All the test cases should pass for obtaining full points.