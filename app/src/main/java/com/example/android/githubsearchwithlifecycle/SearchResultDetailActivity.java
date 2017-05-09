package com.example.android.githubsearchwithlifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.android.githubsearchwithlifecycle.utils.GitHubUtils;

public class SearchResultDetailActivity extends AppCompatActivity {
    private TextView mSearchResultNameTV;
    private TextView mSearchResultDescriptionTV;
    private TextView mSearchResultStarsTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result_detail);

        mSearchResultNameTV = (TextView)findViewById(R.id.tv_search_result_name);
        mSearchResultDescriptionTV = (TextView)findViewById(R.id.tv_search_result_description);
        mSearchResultStarsTV = (TextView)findViewById(R.id.tv_search_result_stars);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(GitHubUtils.SearchResult.EXTRA_SEARCH_RESULT)) {
            GitHubUtils.SearchResult searchResult = (GitHubUtils.SearchResult)intent.getSerializableExtra(GitHubUtils.SearchResult.EXTRA_SEARCH_RESULT);
            mSearchResultNameTV.setText(searchResult.fullName);
            mSearchResultDescriptionTV.setText(searchResult.description);
            mSearchResultStarsTV.setText(Integer.toString(searchResult.stars));
        }
    }
}
