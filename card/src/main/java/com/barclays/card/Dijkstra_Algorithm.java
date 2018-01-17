package com.barclays.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.barclays.card.exception.PathNotFoundException;

public class Dijkstra_Algorithm {

	final static Logger logger = Logger.getLogger(Dijkstra_Algorithm.class);

	private final List<Vertex> nodes;
	private final List<Edge> edges;
	private Set<Vertex> settledNodes;
	private Set<Vertex> unSettledNodes;
	private Map<Vertex, Vertex> predecessors;
	private Map<Vertex, Integer> distance;

	public Dijkstra_Algorithm(Graph graph) {
		// create a copy of vertex and Edges
		this.nodes = new ArrayList<Vertex>(graph.getVertexes());
		this.edges = new ArrayList<Edge>(graph.getEdges());
	}

	public void execute(Vertex source) throws PathNotFoundException {
		logger.info("inside the Algorithm");
		settledNodes = new HashSet<Vertex>();
		unSettledNodes = new HashSet<Vertex>();
		distance = new HashMap<Vertex, Integer>();
		predecessors = new HashMap<Vertex, Vertex>();
		distance.put(source, 0);
		unSettledNodes.add(source);
		try {
			while (unSettledNodes.size() > 0) {
				logger.debug("find minimum distance for node" + unSettledNodes);
				Vertex node = getMinimum(unSettledNodes);
				settledNodes.add(node);
				unSettledNodes.remove(node);
				findMinimalDistances(node);
			}
		} catch (PathNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new PathNotFoundException("unable find path" + e);
		}
	}

	private void findMinimalDistances(Vertex node) throws PathNotFoundException {
		logger.debug("inside the find Minimal Distances ");
		try {
			List<Vertex> adjacentNodes = getNeighbors(node);
			for (Vertex target : adjacentNodes) {
				if (getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)) {
					distance.put(target, getShortestDistance(node) + getDistance(node, target));
					predecessors.put(target, node);
					unSettledNodes.add(target);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new PathNotFoundException("unable find path" + e);
		}

	}

	private int getDistance(Vertex node, Vertex target) {
		for (Edge edge : edges) {
			if (edge.getSource().equals(node) && edge.getDestination().equals(target)) {
				return edge.getWeight();
			}
		}
		throw new RuntimeException("Should not happen");
		// throw new PathNotFoundException("unable find path" +e);
	}

	private List<Vertex> getNeighbors(Vertex node) {
		logger.debug("Getting Neighboring nodes ");
		List<Vertex> neighbors = new ArrayList<Vertex>();
		for (Edge edge : edges) {
			if (edge.getSource().equals(node) && !isSettled(edge.getDestination())) {
				neighbors.add(edge.getDestination());
			}

		}
		return neighbors;
	}

	private Vertex getMinimum(Set<Vertex> vertexes) {
		logger.debug("finding Minimal Distances ");
		Vertex minimum = null;
		for (Vertex vertex : vertexes) {
			if (minimum == null) {
				minimum = vertex;
			} else {
				if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
					minimum = vertex;
				}
			}
		}
		return minimum;
	}

	private boolean isSettled(Vertex vertex) {
		return settledNodes.contains(vertex);
	}

	private int getShortestDistance(Vertex destination) {
		logger.debug("Getting shortest distance ");
		Integer d = distance.get(destination);
		if (d == null) {
			return Integer.MAX_VALUE;
		} else {
			return d;
		}
	}

	/*
	 * This method returns the path from the source to the selected target and
	 * NULL if no path exists
	 */
	public Map<Integer, LinkedList<Vertex>> getPath(Vertex target) {
		logger.debug("getting path form source to destination");
		LinkedList<Vertex> path = new LinkedList<Vertex>();
		Vertex step = target;
		int totalSum = 0;
		// check if a path exists
		if (predecessors.get(step) == null) {
			return null;
		}
		path.add(step);
		while (predecessors.get(step) != null) {
			totalSum += getDistance(step, predecessors.get(step));
			step = predecessors.get(step);
			path.add(step);
		}
		// Put it into the correct order
		Collections.reverse(path);
		Map<Integer, LinkedList<Vertex>> map = new HashMap<>();
		map.put(Integer.valueOf(totalSum), path);
		return map;
	}

}
