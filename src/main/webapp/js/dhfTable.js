var HandleTable = {
	selectedClass : "selectedColor",
	unselectedClass : "unselectedColor",
	mouseOverClass : "mouseOverColor",
	mouseOutClass : "mouseOutColor",
	oddRowClass : "odd",
	evenRowClass : "",
	checkBoxClass : null,
	commandClass : "hide",
	$ : function(a) {
		return document.getElementById(a)
	},
	_driveCheckBox : function(b, a) {
		if (a) {
			b.on("click", function(i) {
				try {
					var e = i.srcElement;
					if (!e) {
						e = i.target
					}
					var f = e.parentTable, g = 0;
					if (e.parentTable.tHead == null) {
						g = 1
					} else {
						if (!window.addEventListener) {
							g = 1
						}
					}
					for (; g < f.rows.length; g++) {
						var j = f.rows[g].cells[0].childNodes[0];
						if (j.checked == e.checked || !j.enable) {
							continue
						}
						j.checked = e.checked;
						var k = "uncheck";
						if (e.checked) {
							k = "check"
						}
						var l = f.getEvents(k);
						for (var c = 0; c < l.length; c++) {
							l[c](i)
						}
					}
					var d = "uncheckAll";
					if (e.checked) {
						d = "checkAll"
					}
					l = f.getEvents(d);
					if (l == null) {
						l = new Array();
						f.exevents[d] = l
					}
					for (var h = 0; h < l.length; h++) {
						l[h](i)
					}
				} catch (i) {
					Console.debug(i)
				}
				return true
			})
		} else {
			b.on("click", function(e) {
				try {
					var c = e.srcElement;
					if (!c) {
						c = e.target
					}
					if (!c.enable) {
						return false
					}
					var d = c.parentTable, h = "uncheck";
					if (c.checked) {
						h = "check"
					}
					var g = d.getEvents(h);
					for (var f = 0; f < g.length; f++) {
						g[f](e)
					}
				} catch (e) {
					Console.debug(e)
				}
				return true
			})
		}
	},
	registerEvent : function(a, b, c) {
		var e = a.exevents[b];
		if (e == null) {
			e = new Array();
			a.exevents[b] = e
		}
		for (var d = 0; d < e.length; d++) {
			if (e[d] == c) {
				return a
			}
		}
		e.push(c);
		return a
	},
	event : function(a) {
		a.on = function(b, c) {
			if (typeof b == "string") {
				if (this.addEventListener) {
					this.addEventListener(b, c, false)
				} else {
					this.attachEvent("on" + b, c)
				}
			}
			return this
		};
		a.un = function(b, c) {
			if (typeof b == "string") {
				if (this.removeEventListener) {
					this.removeEventListener(b, c, false)
				} else {
					this.detachEvent("on" + b, c)
				}
			}
			return this
		};
		return a
	},
	ready : function(g) {
		try {
			g.on = function(i, j) {
				if (typeof i == "string") {
					i = i.toLowerCase();
					if ("check" == i || "uncheck" == i || "checkAll" == i
							|| "unchecktAll" == i) {
						return HandleTable.registerEvent(this, i, j)
					}
					if (this.addEventListener) {
						this.addEventListener(i, j, false)
					} else {
						this.attachEvent("on" + i, j)
					}
				}
				return this
			};
			g.un = function(i, j) {
				if (typeof i == "string") {
					if (this.removeEventListener) {
						this.removeEventListener(i, j, false)
					} else {
						this.detachEvent("on" + i, j)
					}
				}
				return this
			};
			var c = g.rows, e = null;
			for (var d = 0; d < c.length; d++) {
				var f = c[d];
				f.parentTable = g;
				e = f.cells;
				this.event(f);
				for (var h = 0; h < e.length; h++) {
					var a = e[h];
					a.parentTable = g;
					this.event(a);
					if (a.className == this.commandClass) {
						f.operator = a
					}
				}
			}
		} catch (b) {
			Console.debug(b)
		}
	},
	parse : function(n, c, k) {
		c = (c) ? true : false;
		k = (k) ? true : false;
		if (typeof n == "string") {
			n = this.$(n)
		}
		try {
			n.check = c;
			n.multiSelect = k;
			n.exevents = {};
			n.selectedClass = this.selectedClass;
			n.unselectedClass = this.unselectedClass;
			n.mouseOverClass = this.mouseOverClass;
			n.mouseOutClass = this.mouseOutClass;
			n.oddRowClass = this.oddRowClass;
			n.evenRowClass = this.evenRowClass;
			n.checkBoxClass = this.checkBoxClass;
			if (c) {
				if (n.tHead != null) {
					var b = null;
					for (var m = 0; m < n.tHead.childNodes.length; m++) {
						var i = n.tHead.childNodes[m];
						if (i.tagName) {
							if (i.tagName.toLowerCase() == "tr") {
								b = i;
								break
							}
						}
					}
					if (b == null) {
						throw "THEAD\u4e2d\u6ca1\u6709TR\u6807\u7b7e"
					}
					n.tHead.parentTable = n;
					var g = document.createElement("INPUT");
					g.type = "checkbox";
					g.parentTable = n;
					if (this.checkBoxClass) {
						g.setAttribute("class", n.checkBoxClass)
					} else {
						g.style.cssText = "border:0"
					}
					g.isCheckAll = true;
					this.event(g);
					var e = -1, h = b.childNodes;
					for (m = 0; m < h.length; m++) {
						if (h[m].tagName) {
							e = m;
							break
						}
					}
					if (e != -1) {
						var a;
						if (h[e].tagName.toLowerCase() == "th") {
							a = document.createElement("TH")
							a.width = "10px"
						} else {
							a = document.createElement("TD")
						}
						this._driveCheckBox(g, true);
						a.appendChild(g);
						b.insertBefore(a, h[e])
					}
				}
				var l = n.rows;
				for (m = 0; m < l.length; m++) {
					if (l[m].parentNode.tagName.toLowerCase() == "tbody") {
						a = document.createElement("TD");
						a.parentTable = n;
						g = document.createElement("INPUT");
						g.type = "checkbox";
						g.parentTable = n;
						if (window.addEventListener
								|| (xkernel.browser.isIE() && xkernel.browser
										.version() >= 8)) {
							a.setAttribute("class", "center")
						} else {
							a.setAttribute("className", "center")
						}
						if (this.checkBoxClass) {
							g.setAttribute("class", n.checkBoxClass)
						} else {
							g.style.cssText = "border:0"
						}
						this.event(g);
						if (n.tHead == null && m == 0) {
							g.isCheckAll = true;
							this._driveCheckBox(g, true);
							a.appendChild(g);
							l[m].insertBefore(a, l[m].cells[0])
						} else {
							if (m > 0) {
								g.isCheckAll = false;
								enable = l[m].getAttribute("enable");
								if (enable == "false" || enable == false) {
									g.enable = false;
									g.disabled = true
								} else {
									g.enable = true
								}
								checked = l[m].getAttribute("checked");
								this._driveCheckBox(g, false);
								a.appendChild(g);
								l[m].insertBefore(a, l[m].cells[0]);
								if (checked == "true" || checked == true) {
									g.checked = true
								}
							}
						}
					}
				}
			}
			this.ready(n);
			var l = n.rows, f = -1;
			for (var d = 0; d < l.length; d++) {
				if (!this.isDataRow(l[d])) {
					continue
				}
				if (f == -1) {
					f = d
				}
				l[d].selected = false;
				l[d].style.cssText = "cursor:pointer;" + l[d].style.cssText;
				l[d].setSelected = function(o) {
					if (o) {
						this.selected = true;
						if (window.addEventListener
								|| (xkernel.browser.isIE() && xkernel.browser
										.version() >= 8)) {
							this.setAttribute("class",
									this.parentTable.selectedClass)
						} else {
							this.setAttribute("className",
									this.parentTable.selectedClass)
						}
					} else {
						this.selected = false;
						if (window.addEventListener
								|| (xkernel.browser.isIE() && xkernel.browser
										.version() >= 8)) {
							this.setAttribute("class",
									this.parentTable.unselectedClass)
						} else {
							this.setAttribute("className",
									this.parentTable.unselectedClass)
						}
					}
				};
				l[d].isDataRow = function() {
					try {
						if (this.parentTable.tHead == null
								&& this.rowIndex == 0) {
							return false
						}
						if (!window.addEventListener && this.rowIndex == 0) {
							return false
						}
					} catch (o) {
						Console.debug(o)
					}
					return true
				};
				l[d]
						.on(
								"click",
								function(p) {
									el = p.srcElement;
									if (!el) {
										el = p.target
									}
									try {
										var o = el;
										while (o != null) {
											if (o.tagName
													&& o.tagName.toLowerCase() == "tr") {
												break
											} else {
												o = o.parentNode
											}
										}
										if (o.selected || !o.isDataRow()) {
											return true
										}
										var r = o.parentTable.getSelectedRows();
										if (!o.parentTable.multiSelect) {
											for (var s = 0; s < r.length; s++) {
												if (o.rowIndex != r[s].rowIndex) {
													r[s].setSelected(false)
												}
											}
										}
										o.setSelected(true);
										try {
											if (o.operator != null) {
												HandleTable.$("operation").innerHTML = o.operator.innerHTML
											}
										} catch (p) {
											Console.debug(q)
										}
									} catch (q) {
										Console.debug(q)
									}
									return true
								});
				l[d]
						.on(
								"mouseover",
								function(p) {
									el = p.srcElement;
									if (!el) {
										el = p.target
									}
									try {
										var o = el;
										while (o != null) {
											if (o.tagName
													&& o.tagName.toLowerCase() == "tr") {
												break
											} else {
												o = o.parentNode
											}
										}
										if (o == null
												|| o.parentNode.tagName
														.toLowerCase() == "thead"
												|| o.selected || !o.isDataRow()) {
											return true
										}
										if (window.addEventListener
												|| (xkernel.browser.isIE() && xkernel.browser
														.version() >= 8)) {
											o
													.setAttribute(
															"class",
															o.parentTable.mouseOverClass)
										} else {
											o
													.setAttribute(
															"className",
															o.parentTable.mouseOverClass)
										}
									} catch (p) {
										Console.debug(p)
									}
									return true
								});
				l[d]
						.on(
								"mouseout",
								function(p) {
									el = p.srcElement;
									if (!el) {
										el = p.target
									}
									try {
										var o = el;
										while (o != null) {
											if (o.tagName
													&& o.tagName.toLowerCase() == "tr") {
												break
											} else {
												o = o.parentNode
											}
										}
										if (o == null
												|| o.parentNode.tagName
														.toLowerCase() == "thead"
												|| o.selected || !o.isDataRow()) {
											return true
										}
										if (window.addEventListener
												|| (xkernel.browser.isIE() && xkernel.browser
														.version() >= 8)) {
											if (o.selected) {
												o
														.setAttribute(
																"class",
																o.parentTable.selectedClass)
											} else {
												o
														.setAttribute(
																"class",
																o.parentTable.mouseOutClass)
											}
										} else {
											if (o.selected) {
												o
														.setAttribute(
																"className",
																o.parentTable.selectedClass)
											} else {
												o
														.setAttribute(
																"className",
																o.parentTable.mouseOutClass)
											}
										}
									} catch (p) {
										Console.debug(p)
									}
									return true
								});
				if (c) {
					l[d].on("dblclick", function(s) {
						return true;
						var r = s.srcElement;
						if (!r) {
							r = s.target
						}
						try {
							var v = r;
							while (v != null) {
								if (v.tagName
										&& v.tagName.toLowerCase() == "tr") {
									break
								} else {
									v = v.parentNode
								}
							}
							if (!v.isDataRow()) {
								return true
							}
							var q = v.cells[0].childNodes;
							for (var u = 0; u < q.length; u++) {
								if (q[u].tagName.toLowerCase() == "input"
										&& q[u].checked != null) {
									if (!q[u].enable) {
										return true
									}
									if (q[u].checked) {
										q[u].checked = false
									} else {
										q[u].checked = true
									}
									var t = q[u].parentTable, p = "uncheck";
									if (q[u].checked) {
										p = "check"
									}
									var w = t.getEvents(p);
									for (var o = 0; o < w.length; o++) {
										w[o](s, q[u])
									}
									break
								}
							}
						} catch (s) {
							Console.debug(s)
						}
						return true
					})
				}
				if (f == d) {
					try {
						if (l[d].operator != null) {
							HandleTable.$("operation").innerHTML = l[d].operator.innerHTML;
							l[d].setSelected(true)
						}
					} catch (j) {
						console.debug(j)
					}
				}
			}
			n.getEvents = function(p) {
				var o = this.exevents[p];
				if (o == null) {
					o = new Array();
					this.exevents[p] = o
				}
				return o
			};
			n.getSelectedRows = function() {
				var o = this.rows, q = new Array();
				for (var p = 0; p < o.length; p++) {
					if (o[p].selected) {
						q.push(o[p])
					}
				}
				return q
			};
			n.getUnSelectedRows = function() {
				var o = this.rows, q = new Array();
				for (var p = 0; p < o.length; p++) {
					if (!o[p].selected) {
						q.push(o[p])
					}
				}
				return q
			};
			n.getCheckedRows = function() {
				var q = new Array();
				if (!n.check) {
					return q
				}
				var o = this.rows;
				for (var p = 0; p < o.length; p++) {
					if (!o[p].cells[0].childNodes[0].isCheckAll
							&& o[p].cells[0].childNodes[0].checked) {
						q.push(o[p])
					}
				}
				return q
			};
			n.getUncheckedRows = function() {
				var q = new Array();
				if (!n.check) {
					return q
				}
				var o = this.rows;
				for (var p = 0; p < o.length; p++) {
					if (!o[p].cells[0].childNodes[0].isCheckAll
							&& !o[p].cells[0].childNodes[0].checked) {
						q.push(o[p])
					}
				}
				return q
			};
			this.fixed(n)
		} catch (j) {
			console.debug(j)
		}
		return n
	},
	isDataRow : function(a) {
		if (a.rowIndex == 0) {
			return false
		}
		return true
	},
	fixed : function(l) {
		try {
			var g;
			if (parent.tabs) { //监控面板为空
				g = parent.tabs.getActiveTab();
			} else {
				g = parent.parent.tabs.getActiveTab();
			}
			var d = g.getWidth() - l.offsetLeft - l.parentNode.offsetLeft * 2,
			p = g.getHeight() - l.offsetTop,
			b = l.offsetWidth + l.parentNode.clientLeft,
			a = l.offsetHeight,payroll = xkernel.get("payroll"),
			m = xkernel.get("pageturning");
			if (g.title == "运单录入" || g.title == "运单跟踪") {
				p -= 24;
			}
			if (g.title == "客户信息" || g.title == "工厂信息" || g.title == "发送消息") {
				var bw = document.body.offsetWidth;
				if (g.getWidth() != bw && (g.getWidth() != (bw + 17))) {//点击出现弹框的list页面。
					if ((1024 - 18) == bw) {//横向没有滚动条
						d = bw;
					} else {//有滚动条
						d = bw + 17;
					}
					p = 600 - 53 - l.offsetTop;//竖向除了框的高度。
				}
			}
			if (m) {
				p -= m.offsetHeight
			}
			if (payroll) {
				p -= payroll.offsetHeight;
			}
			if (xkernel.browser.isIE()) {
				d -= l.offsetLeft;
				p -= l.parentNode.offsetTop;
				b += l.parentNode.clientLeft
			}
			if (d > b && l.id == "listtab") {
				b = d;
				if (p < a) {
					b -= 18
				}
				l.style.width = b + "px"
			}
			if (d < b || p < a) {
				xkernel.insertHtml("beforebegin", l, '<div id="tablelistdiv"></div>');
				var o = xkernel.get("tablelistdiv");
				if (d < b) {
					o.style.width = d + "px"
				} else {
					if (xkernel.browser.isIE()) {
						l.style.width = (b - 1) + "px"
					}
				}
				if (p < a) {
					if (a <= 400) {
						o.style.height = (a + 17) + "px";
						if (d < b) {
							o.style.width = (d - 17) + "px";
						} else {
							o.style.height = a + "px";
							o.style.width = b + "px";
						}
					} else {
						if (p <= 400) {
							o.style.height = 400 + "px";
							if (d < b) {
								o.style.width = (d - 17) + "px";
							} else {
								l.style.width = (d - 34) + "px";
								o.style.width = (d - 17) + "px";
							}
						} else {
							o.style.height = ( p - 2) + "px";
						}
					}
				} else {//b>p
					o.style.height = (a + 17) + "px";
					if ((a + 17) > p) {
						o.style.width = (o.offsetWidth - 17) + "px";
					} 
				}
				if (g.title == "监控看板") {
					o.style.width = (d - 33) + "px";
				}
				
				o.appendChild(l);
				var c = l.cloneNode(false);
				c.id = "tablefixed";
				xkernel.addClass(c, "tablefixed");
				c.style.width = l.offsetWidth + "px";
				c.style.top = "-99999px";
				var r = l.rows[0], f = r.cloneNode(true), q = f.children, n = r.cells, e = document.defaultView;
				if (e) {
					e = parseInt(document.defaultView.getComputedStyle(n[1],
							null).getPropertyValue("padding-left"))
				} else {
					e = parseInt(n[1].currentStyle.paddingLeft)
				}
				for (var k = 0; k < q.length; k++) {
					q[k].style.width = n[k].clientWidth - e * 2 + "px";
					CH = q[k].children;
					for (var h = 0; h < q[k].children.length; h++) {
						if (CH[h].type == "hidden") {
							q[k].removeChild(CH[h])
						}
					}
				}
				if (r.parentNode != l) {
					f = r.parentNode.cloneNode(false).appendChild(f).parentNode
				}
				f.style.height = r.offsetHeight - e * 2 + "px";
				c.appendChild(f);
				o.appendChild(c);
				xkernel.attachEvent(o, "scroll", function(j) {
					el = j.srcElement;
					if (!el) {
						el = j.target
					}
					try {
						D = el.scrollTop;
						N = el.lastChild;
						if (D > 0) {
							N.style.top = el.scrollTop + "px"
						} else {
							N.style.top = "-99999px"
						}
					} catch (i) {
						console.debug(i)
					}
				})
			}
		} catch (l) {
			console.debug(l)
		}
	}
};
function parse(b, a) {
	HandleTable.parse(b, a)
};
