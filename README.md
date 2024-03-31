# Distribution Helper
This Java Program + Minecraft Schematic enables you to easily generate reports on the distribution of the minecraft nether ores. 

## How to use
1. Download the .litematica file and paste it into your world using litematica
     i. Paste it at the y-coordinate 0
2. Run the command /gamerule commandModificationBlockLimit 999999
3. Run the command block chain from bottom to top
4. Download the jar file or build it yourself
5. Open your minecraft log (Path: %AppData%\.minecraft\logs\latest.log)
6. Find the line where the Command Block Output starts
7. Copy the full Command Block Output into "input.txt", which should be in the same directory as your jar file
8. Run the jar file by
     i. Open the cmd
     ii. Navigate to the directory with your jar and text file
     iii. Run the command "java -jar NAMEOFJARFILE"
      Note: This requires a local java installation
