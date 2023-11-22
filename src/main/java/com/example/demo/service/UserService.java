package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.IntroductionMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Introduction;
import com.example.demo.model.User;

@Service
public class UserService {
	private final UserMapper userMapper;
	private final IntroductionMapper introductionMapper;
	
	@Autowired
	public UserService(UserMapper userMapper, IntroductionMapper introductionMapper) {
		this.userMapper = userMapper;
		this.introductionMapper = introductionMapper;
	}
	
	/**
	 * データベースにユーザーの登録を行う
	 * @param user 登録するユーザーエンティティ
	 */
	public void userRegistration(User user) {
		userMapper.insert(user);
	}
	
	/**
	 * user_idでデータベースに登録されたユーザー情報を取得する
	 * @param id 検索するuser_id
	 * @return 取得したユーザーエンティティ
	 */
	public User userSearchById(String id) {
		return userMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * 登録できるuser_idか確認する
	 * @param userId 確認するuser_id
	 * @return 登録できるかどうかの判定
	 */
	public boolean checkUserRegistrable(String userId) {
		return userMapper.selectByPrimaryKey(userId) == null ? true : false;
	}
	
	/**
	 * user_idでデータベースに登録された自己紹介情報を取得する
	 * @param userId 検索するuser_id
	 * @return 取得した自己紹介情報
	 */
	public Introduction selectByUserId(String userId) {
		return introductionMapper.selectByUserId(userId);
	}
	
	/**
	 * 文字列をハッシュ化された数値にして返す
	 * @param target ハッシュ化する文字列
	 * @return ハッシュ化された数値
	 */
	private int toHash(String target) {
		final int P = 124901413;
		final int TABLE_SIZE = 19;
		
		int hash = 0;
		char[] chTarget = target.toCharArray();
		for(char c: chTarget) {
			hash = (hash * P + c) * ((hash * P + c) % TABLE_SIZE);
		}
		
		return hash;
	}
	
	/**
	 * 渡された文字列を 16進数 10桁のハッシュ化された文字列にする
	 * @param target ハッシュ化する文字列
	 * @return ハッシュ化された文字列
	 */
	public String getHashString(String target) {
		String hexHash = Integer.toHexString(toHash(target));
		if(hexHash.length() < 10) {
			char[] padding = new char[10 - hexHash.length()];
			for(int i = 0; i < padding.length; i++) {
				padding[i] = '0';
			}
			char[] tmp = hexHash.toCharArray();
			char[] fullHash = new char[10];
			System.arraycopy(padding, 0, fullHash, 0, padding.length);
			System.arraycopy(tmp, 0, fullHash, padding.length, tmp.length);
			hexHash = String.valueOf(fullHash);
		} else if(hexHash.length() > 10) {
			char[] cutHash = new char[10];
			char[] tmp = new char[hexHash.length()];
			for(int i = 0; i < cutHash.length; i ++) {
				cutHash[i] = tmp[i];
			}
			hexHash = String.valueOf(cutHash);
		}
		return hexHash;
	}
}
