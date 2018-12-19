package com.beidou.common.util;

import com.beidou.common.entity.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TreeUtils {

	protected TreeUtils(){

	}
	
	public static <T> Tree<T> build(List<Tree<T>> nodes) {
		if (nodes == null) {
			return null;
		}
		List<Tree<T>> topNodes = new ArrayList<>();
		nodes.forEach(children -> {
			String pid = children.getParentId();
			if (pid == null || pid.equals("0")) {
				topNodes.add(children);
				return;
			}
			for (Tree<T> parent : nodes) {
				String id = parent.getId();
				if (id != null && id.equals(pid)) {
					parent.getChildren().add(children);
					children.setHasParent(true);
					parent.setChildren(true);
					return;
				}
			}
		});

		Tree<T> root = new Tree<>();
		root.setId("0");
		root.setParentId("");
		root.setHasParent(false);
		root.setChildren(true);
		root.setChecked(true);
		root.setChildren(topNodes);
		root.setText("根节点");
		Map<String, Object> state = new HashMap<>(16);
		state.put("opened", true);
		root.setState(state);
		return root;
	}


	public static <T> Tree<T> buildMenu(List<Tree<T>> nodes) {
		if (nodes == null) {
			return null;
		}
		List<Tree<T>> topNodes = new ArrayList<>();
		nodes.forEach(parent -> {
			String pid = parent.getParentId();
			String id =parent.getId();
			if (pid == null || pid.equals("0")) {
				topNodes.add(parent);
				return;
			}
			for (Tree<T> children : nodes) {
				if (id != null && id.equals(children.getParentId())) {
					children.getChildren().add(children);
					parent.setHasParent(true);
					children.setChildren(true);
					return;
				}
			}
		});

		Tree<T> root = new Tree<>();
		root.setId("0");
		root.setParentId("");
		root.setHasParent(false);
		root.setChildren(true);
		root.setChecked(true);
		root.setChildren(topNodes);
		root.setText("根节点");
		Map<String, Object> state = new HashMap<>(16);
		state.put("opened", true);
		root.setState(state);
		return root;
	}

	public static <T> List<Tree<T>> buildList(List<Tree<T>> nodes, String idParam) {
		if (nodes == null) {
			return new ArrayList<>();
		}
		List<Tree<T>> topNodes = new ArrayList<>();
		nodes.forEach(children -> {
			String pid = children.getParentId();
			if (pid == null || idParam.equals(pid)) {
				topNodes.add(children);
				return;
			}
			nodes.forEach(parent -> {
				String id = parent.getId();
				if (id != null && id.equals(pid)) {
					parent.getChildren().add(children);
					children.setHasParent(true);
					parent.setChildren(true);
				}
			});
		});
		return topNodes;
	}
}