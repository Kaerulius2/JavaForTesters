package ru.stqa.pft.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class GithubTests {

    @Test
    public void testCommits() throws IOException {
        Github github =new RtGithub("3669ce3afd30fd80b6d02dda78829b4baddc1aed");
        RepoCommits commits = github.repos().get(new Coordinates.Simple("Kaerulius2", "JavaForTesters")).commits();
        for(RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())){
            System.out.println(new RepoCommit.Smart(commit).message());
        }
    }
}
