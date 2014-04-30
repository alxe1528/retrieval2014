package frame.retrieval.engine.analyzer.impl;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Similarity;

import frame.retrieval.engine.analyzer.IRAnalyzerBuilder;
import frame.retrieval.engine.analyzer.IRAnalyzerFactory;


/**
 * 分词器工厂
 *
 * @author 
 * 
 * 
 */

public class RAnalyzerFactory implements IRAnalyzerFactory{
	
	private IRAnalyzerBuilder analyzerBuilder = null;

	public RAnalyzerFactory() {
		
	}

	/**
	 * 注册分词器生成器
	 * 
	 * @param analyzerBuilder
	 */
	public void regAnalyzerBuilder(IRAnalyzerBuilder analyzerBuilder) {
		this.analyzerBuilder = analyzerBuilder;
	}

	/**
	 * 获取索引分词器
	 * 
	 * @return
	 */
	public Analyzer createIndexAnalyzer() {
		return analyzerBuilder.createIndexAnalyzer();
	}

	/**
	 * 获取搜索分词器
	 * 
	 * @return
	 */
	public Analyzer createQueryAnalyzer() {
		return analyzerBuilder.createQueryAnalyzer();
	}

	/**
	 * 获取相似度评估器
	 * 
	 * @return
	 */
	public Similarity createSimilarity() {
		return analyzerBuilder.createSimilarity();
	}

	/**
	 * 创建Query对象
	 * 
	 * @param fieldName
	 * @param queryContent
	 * @return
	 */
	public Query createQuery(String fieldName, String queryContent) {
		return analyzerBuilder.createQuery(fieldName, queryContent);
	}

	@Override
	public Query createQuery(String fieldName, String queryContent, Float score) {
		return analyzerBuilder.createQuery(fieldName, queryContent, score);
	}
}
