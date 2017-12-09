package com.im.project.utils;

import com.im.project.model.Article;
import com.im.project.service.ArticleService;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.File;
import java.io.StringReader;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by demo on 2017/6/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-mybatis.xml" })
public class LuceneUtilTest {
    @Resource
    ArticleService articleService;
    private Directory dir = null;
    private IndexWriter getWriter() throws Exception {
        /**
         * 生成的索引我放在了C盘，可以根据自己的需要放在具体位置
         */

        dir = FSDirectory.open(Paths.get("../index"));
        SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();
        IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
        IndexWriter writer = new IndexWriter(dir, iwc);
        return writer;
    }
    @Test
    public void addIndex() throws Exception {

            IndexWriter writer = getWriter();
        try {
            Document doc = new Document();
            List<Article> list=articleService.selectAllArticle();
            Iterator<Article> iterator=list.iterator();
            while(iterator.hasNext())
            {
                Article article=iterator.next();
                //System.out.println(article.toString());
                doc.add(new TextField("id",String.valueOf(article.getId()),Field.Store.YES));
                doc.add(new TextField("title", article.getTitle(), Field.Store.YES));
                doc.add(new TextField("author", article.getAuthor(), Field.Store.YES));
                doc.add(new TextField("keyword", article.getKeyword(), Field.Store.YES));
                doc.add(new TextField("summary", article.getSummary(), Field.Store.YES));
                doc.add(new TextField("date", article.getDate(), Field.Store.YES));
            }
            /**
             * yes是会将数据存进索引，如果查询结果中需要将记录显示出来就要存进去，如果查询结果
             * 只是显示标题之类的就可以不用存，而且内容过长不建议存进去
             * 使用TextField类是可以用于查询的。
             */
            writer.addDocument(doc);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
            if (null != writer) {
                writer.commit();
                writer.close();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        }
    }

    @Test
    public void searchBlog() throws Exception {
        String q="论文";
        /**
         * 注意的是查询索引的位置得是存放索引的位置，不然会找不到。
         */
        dir = FSDirectory.open(Paths.get("index"));
        IndexReader reader = DirectoryReader.open(dir);
        IndexSearcher is = new IndexSearcher(reader);
        BooleanQuery.Builder booleanQuery = new BooleanQuery.Builder();
        SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();
        /**
         * username和description就是我们需要进行查找的两个字段
         * 同时在存放索引的时候要使用TextField类进行存放。
         */
        QueryParser parser = new QueryParser("keyword", analyzer);
        Query query = parser.parse(q);

        booleanQuery.add(query, BooleanClause.Occur.SHOULD);
        TopDocs hits = is.search(booleanQuery.build(), 100);
        QueryScorer scorer = new QueryScorer(query);
        Fragmenter fragmenter = new SimpleSpanFragmenter(scorer);
        /**
         * 这里可以根据自己的需要来自定义查找关键字高亮时的样式。
         */
        SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter("<b><font color='red'>", "</font></b>");
        Highlighter highlighter = new Highlighter(simpleHTMLFormatter, scorer);
        highlighter.setTextFragmenter(fragmenter);
        List<Article> articleList = new LinkedList<Article>();
        for (ScoreDoc scoreDoc : hits.scoreDocs) {
            Document doc = is.doc(scoreDoc.doc);
            Article article = new Article();
            String title = doc.get("title");
            article.setAuthor(doc.get("author"));
            article.setDate(doc.get("date"));
            article.setId(Integer.parseInt(doc.get("id")));
            article.setSummary(doc.get("summary"));
            article.setKeyword(doc.get("keyword"));
            if (title != null) {
                TokenStream tokenStream = analyzer.tokenStream("title", new StringReader(title));
                String hightLightTile = highlighter.getBestFragment(tokenStream, title);
                article.setTitle(hightLightTile);
                articleList.add(article);
            }
            //System.out.println(article.toString());
        }

    }

    @Test
    public void testFileSystem ()throws Exception{
        FileSystem system = FileSystems.getDefault();
        String url = system.getPath("./index").toString();
        File file = new File(url+"/i.txt");
        //System.out.println(file.exists());
        ////System.out.println(url);
    }
    @Test
    public void test()throws Exception{
            int[] nums={2,5,4,7,8};
            int target=9;
            int[] arr=twoSum(nums,target);
        //System.out.println(arr[0]);
        //System.out.println(arr[1]);
    }
    public int[] twoSum(int[] nums, int target) {
        if(nums.length<2)
            return nums;
        int[] arr=new int[2];
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }
            if(map.containsKey(target-nums[i]))
            {
                arr[0]=map.get(target-nums[i]);
                arr[1]=i;

            }
        }
        return arr;
    }

}