package com.tgt.api.util

import javax.ws.rs.NotFoundException
import java.nio.file.Files
import java.nio.file.Paths



/**
 * Created by z001t7s on 2/21/17.
 */
class StackTraceVisualizerUtil {


    static void writeFoldedStacks(String foldedStackPath, String foldedStacks)
    {

        if(null == foldedStacks || foldedStacks.isEmpty())
        {
            throw new NotFoundException()
        }
        File f= new File(foldedStackPath)
        if(!f.exists())
        {
            f.createNewFile()
        }else
        {
            foldedStacks = '\n'+foldedStacks
        }

        try  {
        BufferedWriter bw = new BufferedWriter(new FileWriter(foldedStackPath, true))

        bw.write(foldedStacks);

        bw.close();

        System.out.println("Done");

    } catch (IOException e) {

        e.printStackTrace();

    }
    }


     static String generateFlameGraph(List<String> allStacks,String foldedStackPath) throws IOException
    {

        Files.deleteIfExists(Paths.get(foldedStackPath));
        for (String stack: allStacks)
        {
            StackTraceVisualizerUtil.writeFoldedStacks('src/main/resources/folded_stacks',stack)
        }
        ProcessBuilder pb = new ProcessBuilder("perl","src/main/resources/flamegraph.pl",foldedStackPath);

        Process p = pb.start();
        StringBuilder builder = new StringBuilder()

       // BufferedWriter writer = Files.newBufferedWriter( Paths.get(flameGraphPath), StandardCharsets.UTF_8);
        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = "";
        while ((line = input.readLine()) != null) {
            builder.append(line);
           builder.append('\n')
        }


        builder.toString()

    }



}
